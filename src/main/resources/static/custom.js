var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 39.9612, lng: -82.9988},
        zoom: 10
    });
}