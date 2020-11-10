let map;
let coords = { lat: 39.9612, lng: -82.9988 };
function initMap() {


    map = new google.maps.Map(document.getElementById('map'), {
        center: coords,
        zoom: 10,
        scrollwheel: false
    });

    let marker = new google.maps.Marker({ position: coords, map: map, animation: google.maps.Animation.BOUNCE });

    let image = {
        url: '/custom_marker.png',
        scaledSize: new google.maps.Size(50, 50)
    };

    let contentString = '<h2>Columbus, OH</h2> <p>Where your dreams come true.</p>';

    let infowindow = new google.maps.InfoWindow({
        content: contentString
    });

    google.maps.event.addListener(marker, 'click', function () {
        infowindow.open(map, marker);
    });

}