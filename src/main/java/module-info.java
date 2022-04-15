module org.openjfx.software_1_fx_assignment {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens org.openjfx.software_1_fx_assignment to javafx.fxml;
    exports org.openjfx.software_1_fx_assignment;
//    exports;
//    opens to
}