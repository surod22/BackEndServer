angular.module('sigfigs', [])
.controller('home', function($scope){
        $http.post('/words/avg_len').success(function(data)){
            $scope.words = data;
        }
})