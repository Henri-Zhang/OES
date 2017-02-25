AUI().use(
    'aui-datepicker',
    function(A) {
        new A.DatePicker(
            {
                trigger: 'input[name*=Date]',
                mask: '%m/%d/%Y',
                popover: {
                    zIndex: 1
                }
            }
        );
    }
);
