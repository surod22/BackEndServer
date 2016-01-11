angular.module('sigfigs', ['ngRoute'])
    .config(function($routeProvider, $httpProvider){

        $routeProvider.when('/', {
            templateUrl : 'home.html'
            controller : 'home'
        }).when('/login', {
            templateUrl : 'login.html',
            controller : 'navigation'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    })
.controller('home', function($scope, $http){
    $http.get('/main/').success(function(data){
        $scope.message = data; 
    })
})
.controller('navigation',
        function( $scope, $http, $location){


        $scope.submitForm = function(){
            $http.post({'/words/avg_len',
                {   text : $scope.words.text},
                {'Content-Type': 'application/json'}
            })
            .then(function(results){
                console.log('mid', results);

            }).catch(function(response){
                console.log('Error', response.data.errors);
            })
        }
        });

        //var authenticate = function(words, callback){
        //    $http.post('/words/avg_len').success(function(data)){
        //                $scope.text = data.text;
        //                $scope.avglen = data.avgLength;
        //    }
        //}

