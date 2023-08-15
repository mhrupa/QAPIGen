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
        createProperty($("#entityProperties"), "EntityProperty");
    });

    $("#addEntityButton").click(function () {
        addEntity($("#entities"));
    });

    $("#submitRequest").click(function () {
        createJSON();
    });

    // Remove property fields dynamically
    $(document).on("click", ".removeProperty", function () {
        $(this).closest(".property").remove();
    });
});

function createJSON() {

    const apiForm = document.getElementById("apiForm");
    const formData = new FormData(apiForm);

    const json = {
        controllerConfig: {
            apiUrl: formData.get("apiUrl"),
            method: formData.get("method"),
            // Add more properties as needed
        },
        requestBody: {
            dtoName: formData.get("dtoName"),
            properties: [],
        },
        requestHeaders: [],
        pathVariables: [],
        requestParams: [],
        entities: [],
    };

    // Process properties for requestBody
    const properties = formData.getAll("PropertyNames[]");
    const propertyTypes = formData.getAll("PropertyTypes[]");
    for (const [index, property] of properties.entries()) {
        json.requestBody.properties.push({
            name: property,
            type: propertyTypes[index],
        });
    }

    // Process request headers
    for (const [index, headerName] of formData
        .getAll("HeaderNames[]")
        .entries()) {
        const headerValue = formData.getAll("HeaderTypes[]")[index];
        json.requestHeaders.push({
            name: headerName,
            value: headerValue,
        });
    }

    // Process path variables
    for (const [index, pathVariableName] of formData
        .getAll("VariableNames[]")
        .entries()) {
        const pathVariableValue = formData.getAll("VariableTypes[]")[
            index
        ];
        json.pathVariables.push({
            name: pathVariableName,
            value: pathVariableValue,
        });
    }

    // Process request parameters
    for (const [index, paramName] of formData
        .getAll("ParameterNames[]")
        .entries()) {
        const paramValue = formData.getAll("ParameterTypes[]")[index];
        json.requestParams.push({
            name: paramName,
            value: paramValue,
        });
    }

    // Process entities
    for (const entityName of formData.getAll("entityName")) {
        const entity = {
            entityName: entityName,
            properties: [],
        };

        for (const [index, entityPropertyName] of formData
            .getAll("EntityPropertyNames[]")
            .entries()) {
            const entityPropertyType = formData.getAll("EntityPropertyTypes[]")[
                index
            ];
            entity.properties.push({
                name: entityPropertyName,
                type: entityPropertyType,
            });
        }

        json.entities.push(entity);
    }
    console.log(JSON.stringify(json, null, 2));
}

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
        $("<input>", { type: "text", class: "form-control", name: propName + "Names[]", placeholder: propName + " Name" })
    ));

    propertyDiv.append($("<div>", { class: "col-auto" }).append(
        $("<select>", { class: "form-control", name: propName + "Types[]" }).append(
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
    createProperty($(entityPropertiesEle[3]), "EntityProperty");
}
