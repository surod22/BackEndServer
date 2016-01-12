angular.module('sigfigs', ['ngRoute'])
    .config(function($routeProvider, $httpProvider){

        $routeProvider.when('/', {
            templateUrl : 'home.html',
            controller : 'home'
        }).when('/login', {
            templateUrl : 'login.html',
            controller : 'navigation'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    })
.controller('home', function($scope, $http){
    $scope.words = []

    $http.get('/main/').success(function(data){
        $scope.words = data

    })

//     $http.post({'/words/avg_len',
//            { text : $scope.words.text},
//            {'Content-Type': 'application/json'}
//     }).success(function(data) {
//            $scope.words.text = data.text
//            $scope.words.avglength = data.avglength
//     })
})
.controller('navigation', function() {

     $scope.submitForm = function(){
        $scope.words = []

        $http.post({'/words/avg_len',
            {   text : $scope.words.text},
                {'Content-Type': 'application/json'}
            })
            .then(function(results){
                console.log('mid', data);
                $scope.words.text = data.text
                $scope.words.avglength = data.avglength
            }).catch(function(response){
                console.log('Error', response.data.errors);
            })
     }

});