
import device.LedConfig;
import device.LedController;
import device.LedDriver;
import device.TestUtils;
import test.TestInput;

// 테스트 대상은 아래 주석과 같이 구현되어 있다. 
// 필요한 경우 아래 주석의 내용을 참고하여 LedTest class에 테스트 입력과 테스트 코드를 작성하시오. 
// NOTE: 테스트 대상 코드는 빌드에 이미 포함되어 있으니 아래 주석을 해제하여 사용하지 마시오.

/**
 * LedDriver.java
 * Led 들의 소비 전력 정보를 가져올 수 잇는 드라이버 인터페이스
 *
public interface LedDriver {

	**
	 * @param index 전력사용량을 가져올 LED번호, 0번 부터 시작한다.
	 * @return index 번째 LED의 전력사용량을 반환
	 *
	int getPowerOf(int index);

}
*/

/**
 * LedController.java
 * Led 등을 제어하는 장비 (테스트 대상)
 * 
public class LedController {

	private LedConfig ledConfig;
	private LedDriver led;
	
	public LedController(LedConfig ledConfig, LedDriver led) {
		// 최소 입력 전력, 최대 입력 전력, 연결되는 LED의 수를 설정하여 초기화한다.
		this.ledConfig = ledConfig;
		this.led = led;
	}

	public boolean checkCondition() {
		// getPowerOf()를 호출하여 각 LED의 소비 전력을 측정 
		Integer[] ledPowers = new Integer[ledConfig.numOfLed];
		for (int i = 0; i < ledConfig.numOfLed; ++i) {
			ledPowers[i] = led.getPowerOf(i);
		}
		
		// 측정한 각 LED 전력이 범위를 벗어났는지 확인
		if (범위를 벗어나는값이 있으면(100, 999, ledPowers))
			return false;
		
		// 입력 전력 범위를 만족하는지 확인
		int powerSum = 전력소모량의합(ledPowers);
		if (범위를벗어나면(ledConfig.powerMin, ledConfig.powerMax, powerSum))
			return false;
		
		// 전력 불균형 지수 단계 계산
		int unbalanceLevelSum = 0;
		for (int i = 0; i < ledPowers.length-1; ++i) {
			int unbalanceLevel = 전력불균형지수계산(ledPowers[i], ledPowers[i+1]);
			// 전력 불균형 지수 단계 중 4단계가 있는지 확인
			if (unbalanceLevel == 4)
				return false;
			
			unbalanceLevelSum += unbalanceLevel;
		}
		
		// 전력 불균형 지수 단계의 합이 한계값을 초과하는지 확인
		if (unbalanceLevelSum > 10)
			return false;
		
		// 위 조건을 모두 통과하면 정상
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
	/* [작성 내용] */
	/* 1. 테스트 케이스를 아래 배열에 추가하시오. 배열의 이름은 수정 불가함, 디폴트로 주어진 내용도 수정 불가함 */
	/* 2. 테스트 케이스 배열 구조 : { 최소 입력 전력, 최대 입력 전력, LED의 개수 N, LED 1의 소비 전력, ..., LED N의 소비 전력} */
	/*  예를 들어, TestInput(new LedConfig(4000, 5000, 5), new Integer[] {950, 950, 650, 850, 900})는 최소 입력 전력이 4000, 최대 입력 전력이 5000, LED의 개수가 5개, LED의 소비 전력이 각각 950, 950, 650, 850, 900 임을 의의한다. */
	public static TestInput[] testParameters = {
		new TestInput(new LedConfig(4000, 5000, 5), new Integer[] {950, 950, 650, 850, 900}),
		new TestInput(new LedConfig(3000, 5000, 8), new Integer[] {500, 500, 600, 400, 700, 500, 500, 500}), // TODO: 항목 1-1 입력을 추가하시오.
		new TestInput(new LedConfig(5000,  6000, 6), new Integer[] { 999, 999, 699, 899, 999, 999}), // TODO: 항목 1-2 입력을 추가하시오.
		new TestInput(new LedConfig(900, 1100, 6), new Integer[] { 100, 100, 100, 301, 200, 199 }), // TODO: 항목 1-3 입력을 추가하시오.
	};

	public static void test_2_1() {
		// TODO: 항목 2-1. 
		// 최소 입력 전력, 최대 입력 전력, LED의 개수가 각각 3000, 4000, 5 이고 LED들의 소비 전력이 300, 400, 400, 600, 300 인 경우를 재현하는 코드를 작성하시오.
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
		// TODO: 항목 2-2. 
		// 최소 입력 전력, 최대 입력 전력, LED의 개수가 각각 1000, 2000, 6 이고 LED들의 소비 전력이 200, 300, 100, 50, 400, 300 인 경우를 재현하는 코드를 작성하시오.
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
	
	
	// 참고용으로 실행하고 싶은 코드가 있다면 아래 main()에 작성하여 활용할 수 있다.
	// main 함수의 코드는 채점과 관련이 없다.
	public static void main(String[] args) {
		// printTestResult는  testParameters의 내용을 테스트 입력으로 수행한 checkCondition()의 결과를 화면에 출력해준다.
		TestUtils.printTestResults(testParameters);
		
		test_2_1();
		test_2_2();
	}
}


