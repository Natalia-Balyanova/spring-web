angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

     $scope.loadProducts = function () {
            $http.get(contextPath + '/products')
                .then(function (response) {
                    $scope.ProductsList = response.data;
                });
        };

        $scope.deleteProduct = function (productId) {
            $http.get(contextPath + '/products/delete/' + productId)
                .then(function (response) {
                    $scope.loadProducts();
                });
        }

        $scope.changeCost = function (productId, delta) {
            $http({
                url: contextPath + '/products/change_price',
                method: 'GET',
                params: {
                    productId: productId,
                    delta: delta
                }
            }).then(function (response) {
                $scope.loadProducts();
            });
        }

        $scope.loadProducts();

            $scope.loadStudents = function () {
                $http.get(contextPath + '/students')
                    .then(function (response) {
                        $scope.StudentsList = response.data;
                    });
            };

            $scope.deleteStudent = function (studentId) {
                $http.get(contextPath + '/students/delete/' + studentId)
                    .then(function (response) {
                        $scope.loadStudents();
                    });
            }

            $scope.changeScore = function (studentId, delta) {
                $http({
                    url: contextPath + '/students/change_score',
                    method: 'GET',
                    params: {
                        studentId: studentId,
                        delta: delta
                    }
                }).then(function (response) {
                    $scope.loadStudents();
                });
            }

            $scope.loadStudents();

});