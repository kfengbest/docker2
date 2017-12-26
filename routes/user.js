
/*
 * GET users listing.
 */

exports.list = function(req, res){
  res.send("respond with a resource");
};

exports.books = function(req, res){
  res.json({ name: 'js' });  
};