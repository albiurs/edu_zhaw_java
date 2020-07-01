module helloGUI {
	exports com.publicept.helloGui;
    requires java.desktop;
    requires helloInt;
    uses com.publicept.helloInt.HelloInt;
}
