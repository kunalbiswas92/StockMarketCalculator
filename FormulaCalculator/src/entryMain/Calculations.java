package entryMain;

public class Calculations {
	static int integerPart;

	public static int sqrtIntegerExtract(String CMP) {

		if (!(CMP.contains("."))) {
			long CurrentMarketPrice = Long.parseLong(CMP);
			double decimalValue = Math.sqrt(CurrentMarketPrice);

			integerPart = (int) (decimalValue);
		} else {
			double CurrentMarketPrice = Double.parseDouble(CMP);
			double decimalValue = Math.sqrt(CurrentMarketPrice);

			integerPart = (int) (decimalValue);
		}

		return integerPart;
	}

}
