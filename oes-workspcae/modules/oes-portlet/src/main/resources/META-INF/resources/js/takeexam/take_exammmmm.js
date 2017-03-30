AUI().use(
    'aui-io-request',
    'anim',
    function (A) {
        var resourceURL = A.one('input[name*=resourceURL]').get('value');
        var examId = A.one('input[name*=examId]').get('value');
        var studentId = A.one('input[name*=studentId]').get('value');
        var index = 0;
        var size = A.one('input[name*=size]').get('value');

        var prevQuestionButton = A.one('button[name*=prevQuestion]');
        var nextQuestionButton = A.one('button[name*=nextQuestion]');
        prevQuestionButton.set("disabled", "disabled");

        A.all('input[type="radio"]').on(
            'click',
            function(event) {
                var node = event.target;
                var result = node.get('value');
                var questionOrder = node.get('name').split('_').pop();
                A.io.request(resourceURL, {
                    method: 'post',
                    data: {
                        'examId': examId,
                        'studentId': studentId,
                        'questionOrder': questionOrder,
                        'result': result
                    }
                });
            }
        );

        prevQuestionButton.on(
                'click',
                function(e) {
                    nextQuestionButton.set("disabled", "");
                    var questionList = A.one('div.question-list');
                    index--;
                    var targetMarginLeft = -500 * index;
                    new A.Anim({
                        node: 'div.question-list',
                        duration: 1,
                        to: {
                            'margin-left': targetMarginLeft.toString(),
                        },
                        easing: A.Easing.bounceOut
                    }).run();

                    if (index <= 0) {
                        prevQuestionButton.set("disabled", "disabled");
                    }

                }
            );

            nextQuestionButton.on(
                'click',
                function(e) {
                    prevQuestionButton.set("disabled", "");
                    var questionList = A.one('div.question-list');
                    index++;
                    var targetMarginLeft = -500 * index;
                    new A.Anim({
                        node: 'div.question-list',
                        duration: 1,
                        to: {
                            'margin-left': targetMarginLeft.toString(),
                        },
                        easing: A.Easing.bounceOut
                    }).run();

                    if (index >= size - 1) {
                        nextQuestionButton.set("disabled", "disabled");
                        A.one('a[id*=submit]').removeClass('hide');
                    }

                }
            );

    }
);