AUI().use(
    'aui-io-request',
    function (A) {
        var resourceURL = A.one('input[name*=resourceURL]').get('value');
        var examId = A.one('input[name*=examId]').get('value');
        var studentId = A.one('input[name*=studentId]').get('value');

        var examIdParam = A.one('input[name*=examId]').get('name');
        var studentIdParam = A.one('input[name*=studentId]').get('name');
        var questionOrderParam = A.one('input[name*=questionOrder]').get('name');
        var resultParam = A.one('input[name*=result]').get('name');
        A.all('input[type="radio"]').on(
            'click',
            function(event) {
                var node = event.target;
                var result = node.get('value');
                var questionOrder = node.get('name').split('_').pop();
                A.io.request(resourceURL, {
                    method: 'post',
                    data: {
                        examIdParam: examId,
                        studentIdParam: studentId,
                        questionOrderParam: questionOrder,
                        resultParam: result
                    }
                });
            }
        );
    }
);