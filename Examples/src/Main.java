//main classfile


double result;
switch (operation){
case "+":
	result = CalcHelper.addValues(d1, d2); //this is calling a static method
case "-":
	result = CalcHelper.subtractValues(d1, d2);
case "*":
	result = CalcHelper.multiplyValues(d1, d2);
case "/":
	result = CalcHelper.divideValues(d1, d2);
}