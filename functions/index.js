const functions = require('firebase-functions');

// Create and Deploy Your First Cloud Functions
// https://firebase.google.com/docs/functions/write-firebase-functions

exports.tstFuncOne = functions.https.onRequest((request, response) => {
    const textData = request.query.textData;
    const json = {
        input: ('Hello ' + textData)
    };
    console.log(textData);
    response.send(JSON.stringify(json));
});
