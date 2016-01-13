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

        $scope.images =[
            {url: '/images/DevasBack.png'},
            {url: '/images/DevasFront.png'},
            {url: '/images/AppDevelopment.jpg'},
            {url: '/images/BotballGroundAerial.jpg'},
            {url: '/images/FrcRobotics.jpg'},
            {url: '/images/EngCompetitions.jpg'},
            {url: '/images/CellBackground.png'},
            {url: '/images/DevasTshirtRegularEarth.jpg'},
            {url: '/images/GlamsTshirtsDesing.jpg'},
            {url: '/images/SummerBridge2011Green.jpg'},
            {url: '/images/SummerBridge2011tshirt.jpg'},
            {url: '/images/Flyer.png'},
            {url: '/images/FlyerRuntitle.png'},
            {url: '/images/FlyerRuntitleFinalUser300PNG.png'},
            {url: '/images/MapFinal.png'},
            {url: '/images/MuralBlack1.jpg'},
            {url: '/images/MuralBlue5.jpg'},
            {url: '/images/SplashScreen3_320x416.png'},
            {url: '/images/StoreAdd.png'},
            {url: '/images/SplashScreen.png'},
            {url: '/images/UnderWater.jpg'}

        ]

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
                $scope.avglength = response.data.avglength
            })

            $http({
                url: '/words/most_com',
                method: "POST",
                data: {'text': $scope.text}
            }).then(function (response) {
                $scope.mostcommon = response.data.mostcommon
            })
        }
    });