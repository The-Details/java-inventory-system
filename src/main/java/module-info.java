module wgu.softwarejfx.software_1_fx_assignment_rework {
    requires javafx.controls;
    requires javafx.fxml;


    opens wgu.softwarejfx.software_1_fx_assignment_rework to javafx.fxml;
    exports wgu.softwarejfx.software_1_fx_assignment_rework;
}