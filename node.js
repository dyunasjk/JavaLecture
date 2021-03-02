var http = require('http');

http.createServer(function (request, response) {
    response.writeHead(200, { 'conent-type': 'text/html'});
    response.write('Hello World !!');
    response.end();

}).listen(8889);

console.log('server running at http://localhost:8080');s