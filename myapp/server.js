var express = require('express');
var app = express();

app.use(express.static('public'));

app.use(express.static('public'));
app.get('/index.html', function (req, res) {
   res.sendFile( __dirname + "/" + "index.html" );
})

app.get('/process_get', function (req, res) {
   //This is what it gets from the form on the imput
   // Prepare output in JSON format
   response = {
      first_name:req.query.first_name,
      last_name:req.query.last_name,
      color:req.query.fav_color
   };
   //prints what is imputed
   console.log(response);
   //posts the info on the next page
   res.end(JSON.stringify(response));
})

var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port

   console.log("Example app listening at http://%s:%s", host, port)

})


//This is an example of a function for js5 and then js6

var Smartphones = [
   { name: 'iphone', price:100},
   { name: 'Galaxy 56', price:200}
   ];

//ES5

console.log(Smartphones.map(function (smartPhone){
   return smartPhone.price;
   }

   //ES6

console.log(Smartphones.map(
   smartPhone => smartPhone.price


   //How to define a new mongoose schema (class)

   var Blogschema = new Schema({
      ...
   })


//Makes a new array from mapping the old array to a new one
odds = evens.map(v => v +1)

//pairs like this are lists of objects an go into curly brackets
pairs = evens.map(v => ({even: v, odd:v + 1}))

//nums mapps the values of evens with the parameteres v and i into a new array
nums = evens.map((v,i) => v + i)

//Old way
function f (x,y=7,z=42){
   return x + y+ z 

}

f(1)


//New way ( I THINK)
//The 7 and 42 should be default
let f = (x,y=7,z=42) => x + y+ z
f(3,4,5)

//This is called rest variable that is an array that has elemets from 0 to othernums
function(a, b, ...OtherNums)

//This is for formating into a message

var customer = {name: "foo"}
var message = 'Hello ${customer.name}'