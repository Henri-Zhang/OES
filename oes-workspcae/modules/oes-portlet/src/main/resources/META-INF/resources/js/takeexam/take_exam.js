AUI().use(
    'aui-io-request',
    function (A) {
        var resourceURL = A.one('input[name*=resourceURL]').get('value');
        var examId = A.one('input[name*=examId]').get('value');
        var studentId = A.one('input[name*=studentId]').get('value');
        A.all('input[type="radio"]').on(
            'click',
            function(event) {
                var node = event.target;
                var result = node.get('value');
                var questionOrder = node.get('name').split('_').pop();
                A.io.request(resourceURL, {
                    method: 'post',
                    data: {
                        <portlet:namespace />examId: examId,
                        <portlet:namespace />studentId: studentId,
                        <portlet:namespace />questionOrder: questionOrder,
                        <portlet:namespace />result: result
                    }
                });
            }
        );
    }
);