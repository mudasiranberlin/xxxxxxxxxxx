(function(){

  angular.module('plunker', []);

  angular.module('plunker').controller('MainCtrl', MainController);
  function MainController ($http){
    var mctrl = this;
    mctrl.people = this;

   $http({
		method      : 'GET',
		url         : 'http://private-a73e-aquentuxsociety.apiary-mock.com/members'
	})
	.success(function(data) {
	   mctrl.people = data;
		console.log(mctrl.people);
    }).error(function(error) {
    });
  }  
})();
