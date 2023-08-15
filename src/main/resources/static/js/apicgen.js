$(document).ready(function () {
    // Add property fields dynamically
    $("#addPropertyButton").click(function () {
        createProperty($("#properties"), "Property");
    });

    $("#addHeaderButton").click(function () {
        createProperty($("#headerProperties"), "Header");
    });

    $("#addPathVariableButton").click(function () {
        createProperty($("#pathVariables"), "Variable");
    });

    $("#addRequestParametsButton").click(function () {
        createProperty($("#requestParams"), "Parameter");
    });

    $("#addEntityPropertyButton").click(function () {
        createProperty($("#entityProperties"), "Property");
    });

    $("#addEntityButton").click(function () {
        addEntity($("#entities"));
    });

    // Remove property fields dynamically
    $(document).on("click", ".removeProperty", function () {
        $(this).closest(".property").remove();
    });
});

function addEntity(ele) {
    let propertyDiv = $("<div>", { class: "row g-3 align-items-center pt-2" });

    propertyDiv.append($("<div>", { class: "col-auto" }).append(
        $("<label>", { class: "col-form-label", for: "entityName" }).text("Entity Name")
    ));

    propertyDiv.append($("<div>", { class: "col-auto" }).append(
        $("<input>", { type: "text", class: "form-control", id: "entityName", name: "entityName", value: "SampleEntity" })
    ));

    propertyDiv.append($("<div>", { class: "col-auto" }).append(
        $("<button>", { type: "button", class: "btn btn-primary", id: "addEntityPropertyButton" }).text("Add Property")
            .on("click", function () {
                addEntityProperty(this);
            })
    ));

    propertyDiv.append($("<div>", { class: "param" }).append(
        $("<div>", { id: "entityProperties" })
    ));

    $(ele).append(propertyDiv);
}

function createProperty(ele, propName) {
    let propertyDiv = $("<div>", { class: "property row g-3 align-items-center pt-2" });

    propertyDiv.append($("<div>", { class: "col-auto" }).append(
        $("<input>", { type: "text", class: "form-control", name: "propertyNames[]", placeholder: propName + " Name" })
    ));

    propertyDiv.append($("<div>", { class: "col-auto" }).append(
        $("<select>", { class: "form-control", name: "propertyTypes[]" }).append(
            $("<option>", { value: "0", selected: "selected" }).text("Please Select"),
            $("<option>", { value: "String" }).text("String"),
            $("<option>", { value: "int" }).text("int"),
            $("<option>", { value: "long" }).text("long"),
            $("<option>", { value: "double" }).text("double"),
            $("<option>", { value: "short" }).text("short"),
            $("<option>", { value: "byte" }).text("byte"),
            $("<option>", { value: "boolean" }).text("boolean"),
        )
    ));

    propertyDiv.append($("<div>", { class: "removeProperty col-auto" }).append(
        $("<button>", { type: "button", class: "btn btn-danger", title: "remove" }).append(
            $("<i>"),
            "&nbsp;-&nbsp;"
        )
    ));


    ele.append(propertyDiv);
}

function addEntityProperty(ele) {
    let entityPropertiesEle = $(ele).parent().parent().children();
    createProperty($(entityPropertiesEle[3]), "Property");
}
