public class MakeDailyView extends Make<AndroidWindow> {
	@Override
	public AndroidWindow make() {
		System.out.println("Daily view");
		return new DailyView();
	}
}
