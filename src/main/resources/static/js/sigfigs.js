angular.module('sigfigs', ['ngRoute'])
    .config(function ($routeProvider, $httpProvider) {
        $routeProvider.when('/', {
            templateUrl: 'home.html',
            controller: 'home'
        }).when('/words', {
            templateUrl: 'words.html',
            controller: 'navigation'
        }).otherwise('/');
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    })

    .controller('home', function ($scope, $http) {
        $scope.words = [];
        $http.get('/main/').success(function (data) {
            $scope.words = data;
        });

    })

    .controller('navigation', function ($scope, $http, $log) {

        $scope.text = ''
        $scope.avglength = ''
        $scope.mostcommon = ''

        $scope.submitForm = function () {
            $http({
                url: '/words/avg_len',
                method: "POST",
                data: {'text': $scope.text}
            }
            ).then(function (response) {
                 console.log(response.data);
                $scope.avglength = response.data.avglength
            })

            $http({
                url: '/words/most_com',
                method: "POST",
                data: {'text': $scope.text}
            }).then(function (response) {
                console.log(response.data);
                $scope.mostcommon = response.data.mostcommon
            })
        }
    });