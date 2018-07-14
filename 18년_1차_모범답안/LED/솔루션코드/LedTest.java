
import device.LedConfig;
import device.LedController;
import device.LedDriver;
import device.TestUtils;
import test.TestInput;

// �׽�Ʈ ����� �Ʒ� �ּ��� ���� �����Ǿ� �ִ�. 
// �ʿ��� ��� �Ʒ� �ּ��� ������ �����Ͽ� LedTest class�� �׽�Ʈ �Է°� �׽�Ʈ �ڵ带 �ۼ��Ͻÿ�. 
// NOTE: �׽�Ʈ ��� �ڵ�� ���忡 �̹� ���ԵǾ� ������ �Ʒ� �ּ��� �����Ͽ� ������� ���ÿ�.

/**
 * LedDriver.java
 * Led ���� �Һ� ���� ������ ������ �� �մ� ����̹� �������̽�
 *
public interface LedDriver {

	**
	 * @param index ���»�뷮�� ������ LED��ȣ, 0�� ���� �����Ѵ�.
	 * @return index ��° LED�� ���»�뷮�� ��ȯ
	 *
	int getPowerOf(int index);

}
*/

/**
 * LedController.java
 * Led ���� �����ϴ� ��� (�׽�Ʈ ���)
 * 
public class LedController {

	private LedConfig ledConfig;
	private LedDriver led;
	
	public LedController(LedConfig ledConfig, LedDriver led) {
		// �ּ� �Է� ����, �ִ� �Է� ����, ����Ǵ� LED�� ���� �����Ͽ� �ʱ�ȭ�Ѵ�.
		this.ledConfig = ledConfig;
		this.led = led;
	}

	public boolean checkCondition() {
		// getPowerOf()�� ȣ���Ͽ� �� LED�� �Һ� ������ ���� 
		Integer[] ledPowers = new Integer[ledConfig.numOfLed];
		for (int i = 0; i < ledConfig.numOfLed; ++i) {
			ledPowers[i] = led.getPowerOf(i);
		}
		
		// ������ �� LED ������ ������ ������� Ȯ��
		if (������ ����°��� ������(100, 999, ledPowers))
			return false;
		
		// �Է� ���� ������ �����ϴ��� Ȯ��
		int powerSum = ���¼Ҹ�����(ledPowers);
		if (�����������(ledConfig.powerMin, ledConfig.powerMax, powerSum))
			return false;
		
		// ���� �ұ��� ���� �ܰ� ���
		int unbalanceLevelSum = 0;
		for (int i = 0; i < ledPowers.length-1; ++i) {
			int unbalanceLevel = ���ºұ����������(ledPowers[i], ledPowers[i+1]);
			// ���� �ұ��� ���� �ܰ� �� 4�ܰ谡 �ִ��� Ȯ��
			if (unbalanceLevel == 4)
				return false;
			
			unbalanceLevelSum += unbalanceLevel;
		}
		
		// ���� �ұ��� ���� �ܰ��� ���� �Ѱ谪�� �ʰ��ϴ��� Ȯ��
		if (unbalanceLevelSum > 10)
			return false;
		
		// �� ������ ��� ����ϸ� ����
		return true;
	}
}
*/

/**
 * LedConfig.java
public class LedConfig {
	public LedConfig(int powerMin, int powerMax, int numberOfLed) {
		this.powerMin = powerMin;
		this.powerMax = powerMax;
		this.numOfLed = numberOfLed;
	}
	public int powerMin;
	public int powerMax;
	public int numOfLed;
}
*/

/**
 * TestInput.java
public class TestInput {
	public TestInput(LedConfig ledConfig, Integer[] ledPowers) {
		this.config = ledConfig;
		this.ledPowers = ledPowers;
	}
	public LedConfig config;
	public Integer[] ledPowers;
}
*/

public class LedTest {
	/* [�ۼ� ����] */
	/* 1. �׽�Ʈ ���̽��� �Ʒ� �迭�� �߰��Ͻÿ�. �迭�� �̸��� ���� �Ұ���, ����Ʈ�� �־��� ���뵵 ���� �Ұ��� */
	/* 2. �׽�Ʈ ���̽� �迭 ���� : { �ּ� �Է� ����, �ִ� �Է� ����, LED�� ���� N, LED 1�� �Һ� ����, ..., LED N�� �Һ� ����} */
	/*  ���� ���, TestInput(new LedConfig(4000, 5000, 5), new Integer[] {950, 950, 650, 850, 900})�� �ּ� �Է� ������ 4000, �ִ� �Է� ������ 5000, LED�� ������ 5��, LED�� �Һ� ������ ���� 950, 950, 650, 850, 900 ���� �����Ѵ�. */
	public static TestInput[] testParameters = {
		new TestInput(new LedConfig(4000, 5000, 5), new Integer[] {950, 950, 650, 850, 900}),
		new TestInput(new LedConfig(3000, 5000, 8), new Integer[] {500, 500, 600, 400, 700, 500, 500, 500}), // TODO: �׸� 1-1 �Է��� �߰��Ͻÿ�.
		new TestInput(new LedConfig(5000,  6000, 6), new Integer[] { 999, 999, 699, 899, 999, 999}), // TODO: �׸� 1-2 �Է��� �߰��Ͻÿ�.
		new TestInput(new LedConfig(900, 1100, 6), new Integer[] { 100, 100, 100, 301, 200, 199 }), // TODO: �׸� 1-3 �Է��� �߰��Ͻÿ�.
	};

	public static void test_2_1() {
		// TODO: �׸� 2-1. 
		// �ּ� �Է� ����, �ִ� �Է� ����, LED�� ������ ���� 3000, 4000, 5 �̰� LED���� �Һ� ������ 300, 400, 400, 600, 300 �� ��츦 �����ϴ� �ڵ带 �ۼ��Ͻÿ�.
		LedDriver fakeDriver = new LedDriver() {
			private int[] fakePowers = {300, 400, 400, 600, 300};

			@Override
			public int getPowerOf(int index) {
				return fakePowers[index];
			}
		};
		LedController controller = new LedController(new LedConfig(3000, 4000, 5), fakeDriver);
		controller.checkCondition();
	}

	public static void test_2_2() {
		// TODO: �׸� 2-2. 
		// �ּ� �Է� ����, �ִ� �Է� ����, LED�� ������ ���� 1000, 2000, 6 �̰� LED���� �Һ� ������ 200, 300, 100, 50, 400, 300 �� ��츦 �����ϴ� �ڵ带 �ۼ��Ͻÿ�.
		LedDriver fakeDriver = new LedDriver() {
			private int[] fakePowers = {200, 300, 100, 50, 400, 300};

			@Override
			public int getPowerOf(int index) {
				return fakePowers[index];
			}
		};
		LedController controller = new LedController(new LedConfig(1000, 2000, 6), fakeDriver);
		controller.checkCondition();
	}
	
	
	// ��������� �����ϰ� ���� �ڵ尡 �ִٸ� �Ʒ� main()�� �ۼ��Ͽ� Ȱ���� �� �ִ�.
	// main �Լ��� �ڵ�� ä���� ������ ����.
	public static void main(String[] args) {
		// printTestResult��  testParameters�� ������ �׽�Ʈ �Է����� ������ checkCondition()�� ����� ȭ�鿡 ������ش�.
		TestUtils.printTestResults(testParameters);
		
		test_2_1();
		test_2_2();
	}
}


