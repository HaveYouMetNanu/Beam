
document.getElementById("latlonform").onsubmit = async function(event) {
   event.preventDefault();
   console.log("here in function");
   console.log(event);
   var lat = event.target[0].value;
   var lon =  event.target[1].value;
   var radius =  event.target[2].value;
   var constructedurl = `http://localhost:8080/location?lat=${lat}&lon=${lon}&radius=${radius}`;
   console.log(constructedurl);
   var latlongs;
   var response = await fetch(constructedurl, {method:'GET',
        mode: 'cors',
        headers: { 'Content-Type': 'application/json'}
        }
     ).then(data => data.json()).then(result => {
     const table = document.getElementById("testBody");
     table.innerHTML = "";
         result.forEach( item => {
           let row = table.insertRow();
           let date = row.insertCell(0);
           date.innerHTML = item.lat;
           let name = row.insertCell(1);
           name.innerHTML = item.lon;
         });
         }
         );
};

