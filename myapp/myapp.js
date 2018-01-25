var express = require('express')
var app = express()


// This is the place where the pictures and stuff are stored, 'public'
app.use(express.static('public'));


app.get('/', function (req, res) {
	//This is what is shown on the screen
	//This is what is given to the web app
  res.send('Hello World!')
})

app.post('/', function (req, res) {
	//This is what is shown on the screen
	//This is what is given to the web app
  res.send('Hello World!')
})

})

var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port

   console.log("Example app listening at http://%s:%s", host, port)

})

//app.listen(3000, function () {
	//This is what prints in the terminal
	//This is what is returned to the program
  //console.log('Example app listening on port 3000!')
//})
//Express is a minimal and flexible Node.js web application 
//framework that provides a robust set of features to develop
//web and mobile applications. It facilitates the rapid development 
//of Node based Web applications. 
