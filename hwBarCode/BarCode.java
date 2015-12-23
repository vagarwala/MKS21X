public class BarCode implements Comparable{
	// instance variables
   private String _zip;
   private int _checkDigit;
   private static String[] codes = new String[]{"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};

	// constructors
	//precondtion: zip.length() = 5 and zip contains only digits.
	//postcondition: throws a runtime exception zip is not the correct length
	//               or zip contains a non digit
	//               _zip and _checkDigit are initialized.
	public BarCode(String zip) {
		try{
            int newZip = Integer.parseInt(zip);
        } catch (NumberFormatException e){
            System.out.println("Enter a valid zip code!");
        }
        if (zip.length() != 5){
        	throw new RuntimeException("Enter the correct length!");
        }else{
        	_zip = zip;
	        _checkDigit = checkSum();
	        _zip = zip + String.valueOf(_checkDigit);
    	}
	}

	// postcondition: Creates a copy of a bar code.
	public BarCode(BarCode x){
		_zip = x.getZip();
		BarCode copy = new BarCode(_zip);
		_checkDigit = checkSum();
		_zip +=  String.valueOf(_checkDigit);
	}

	public String getZip(){
		return _zip.substring(0,_zip.length()-1);
    }

	//post: computes and returns the check sum for _zip
	private int checkSum(){
		int sum = 0;
		for (char c: _zip.toCharArray()){
			sum += c - '0';
		}
		return sum % 10;
	}

	//postcondition: format zip + check digit + barcode 
	//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
	public String toString(){
		String zip = "";
		for (char digit : _zip.toCharArray()){
			zip += codes[Character.getNumericValue(digit)];
		}
		return _zip + "     " + zip;
	}


	public boolean equals(Object other){
		if (!(other instanceof BarCode)){
			return false;
		}
		return _zip.equals(((BarCode)other)._zip);
	}
	// postcondition: compares the zip + checkdigit 
	//  ex 084518 < 193418 true
	//     084528 > 000000 true

	public int compareTo(Object other){
		return toString().compareTo(other.toString());


	} 

}