$.UserFormValidator = function() {
    var email_regex = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i;
    var phone_regex = /^0[0-9]{9}$/;
    var name_reg = /^\D+$/;

    var hideAllErrors = function() {
        $("#firstName_error").html('').hide();
        $("#lastName_error").html('').hide();
        $("#phone_error").html('').hide();
        $("#email_error").html('').hide();
        $("#role_error").html('').hide();
        $("#firstName.errors").html('').hide();
    };

    this.validate = function() {
        var isValid = true;
        hideAllErrors();

        if ($("#user_first_name").val().length == 0) {
            isValid = false;
            $("#firstName_error").html("Please enter first name");
            $("#firstName_error").show();
        }
        if (!name_reg.test($("#user_first_name").val())) {
            isValid = false;
            $("#firstName_error").html("Please enter valid first name");
            $("#firstName_error").show();
        }

        if ($("#user_last_name").val().length == 0) {
            isValid = false;
            $("#lastName_error").html("Please enter last name");
            $("#lastName_error").show();
        }

        if (!name_reg.test($("#user_last_name").val())) {
            isValid = false;
            $("#lastName_error").html("Please enter valid last name");
            $("#lastName_error").show();
        }

        if ($("#user_middle_name").val().length != 0 && !name_reg.test($("#user_middle_name").val())) {
            isValid = false;
            $("#middleName_error").html("Please enter valid middle name");
            $("#middleName_error").show();
        }

        if ($("#phoneNumber").val().length == 0 || !phone_regex.test($("#phoneNumber").val())) {
            isValid = false;
            $("#phoneNumberError").html("Please enter valid phone number");
            $("#phoneNumberError").show();
        }

        if (!name_reg.test($("#user_first_name").val())) {
            isValid = false;
            $("#firstName_error").html("Please enter valid first name");
            $("#firstName_error").show();
        }

        var regexMatch = $("#user_role option:selected").text().match(/\(.*?\)/);
        var role = (regexMatch != null) ? regexMatch[0].substring(1, regexMatch[0].length - 1) : null;
        console.log(role);
        if (role == null) {
            isValid = false;
            $("#role_error").html("Please select a role");
            $("#role_error").show();
        }
        if (role == 'Super Administrator' || role == 'Facility Administrator' || role == 'Call Centre Administrator' || role == 'Health Care Administrator') {
            if ($("#user_email").val().length == 0 || !email_regex.test($("#user_email").val())) {
                isValid = false;
                $("#email_error").html("Please enter valid email");
                $("#email_error").show();
            }
        }
        return isValid;
    };
};

$.StaffForm = function() {
    var validator = new $.UserFormValidator();

    var submitForm = function() {
        if (validator.validate()) {
            $('#staffForm').submit();
        }
    };
    var bootstrap = function() {
        $("#staffForm").formly({'onBlur':false, 'theme':'Light'});
        $("#submitNewUser").click(submitForm);
    };
    $(bootstrap);
};

$(document).ready(function() {
    new $.StaffForm();
});