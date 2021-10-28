document.addEventListener("DOMContentLoaded", function() 
{
   

  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() 
  {
      
      if(xhr.readyState === 4) 
      {

          console.log(JSON.parse(xhr.responseText));

          var flightArray = JSON.parse(xhr.responseText);

          flightArray.forEach(flightElement => {
             addFlightToTable(flightElement);
          
          });
      }

  }

  xhr.open('GET', '/flight/api/flights');

  xhr.send();

});

              //  ****************************************************

function addFlightToTable(flight)
{
   var tr = document.createElement('tr');
   var id = document.createElement('td');
   var airline = document.createElement('td');
   var flightNumber = document.createElement('td');
   var departureCity = document.createElement('td');
   var departureDate = document.createElement('td');
   var departureGate = document.createElement('td');
   var arrivalCity = document.createElement('td');
   var arrivalDate = document.createElement('td');
   var arrivalGate = document.createElement('td');
 
    
   
   id.innerText = flight.id;
   airline.innerText = flight.airline;
   flightNumber.innerText = flight.flightNumber; 
   departureCity.innerText = flight.departureCity;
   departureDate.innerText = flight.departureDate;
   departureGate.innerText = flight.departureGate;
   arrivalCity.innerText = flight.arrivalCity;
   arrivalDate.innerText = flight.arrivalDate;
   arrivalGate.innerText = flight.arrivalGate;

  

   tr.appendChild(id);
   tr.appendChild(airline);
   tr.appendChild(flightNumber);
   tr.appendChild(departureCity);
   tr.appendChild(departureDate);
   tr.appendChild(departureGate);
   tr.appendChild(arrivalCity);
   tr.appendChild(arrivalDate);
   tr.appendChild(arrivalGate);

 
   
   document.getElementById('flight-table-body').appendChild(tr);}




                       
  



document.getElementById('add-flight').addEventListener('click', function(event) 
{

  event.preventDefault();
   
  //get data from form
  var airlineOnForm = document.getElementById('flight-airline').value;
  var flightnumberonForm = document.getElementById('flight-flightnumber').value;
  var departurecityonForm = document.getElementById('flight-departurecity').value;
  var departuredateonForm = document.getElementById('flight-departuredate').value;
  var departuregateonForm = document.getElementById('flight-departuregate').value;
  var arrivalcityonForm = document.getElementById('flight-arrivalcity').value;
  var arrivaldateonForm = document.getElementById('flight-arrivaldate').value;
  var arrivalgateonForm = document.getElementById('flight-arrivalgate').value;

  var flight = {

     airline : airlineOnForm,
     flightNumber : flightnumberonForm,
     departureCity : departurecityonForm,
     departureDate : departuredateonForm,
     departureGate : departuregateonForm,
     arrivalCity : arrivalcityonForm,
     arrivalDate : arrivaldateonForm,
     arrivalGate : arrivalgateonForm
  };
  

  //AJAX call

  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() 
   {
      
       if(xhr.readyState === 4) 
      {
  
         var updatedFlight = JSON.parse(xhr.responseText);

          addFlightToTable(updatedFlight);

         document.getElementById('new-flight-form').reset();
      }

  }

  xhr.open('POST', '/flight/api/flights');

  xhr.send(JSON.stringify(flight));

 });






   

document.getElementById('update-flight').addEventListener('click', function(event) 
{

  event.preventDefault();
   
  //get data from form
  var idOnForm = document.getElementById('flight-id').value;
  var airlineOnForm = document.getElementById('flight-airline').value;
  var flightnumberonForm = document.getElementById('flight-flightnumber').value;
  var departurecityonForm = document.getElementById('flight-departurecity').value;
  var departuredateonForm = document.getElementById('flight-departuredate').value;
  var departuregateonForm = document.getElementById('flight-departuregate').value;
  var arrivalcityonForm = document.getElementById('flight-arrivalcity').value;
  var arrivaldateonForm = document.getElementById('flight-arrivaldate').value;
  var arrivalgateonForm = document.getElementById('flight-arrivalgate').value;

  var flight = {
      
     id: idOnForm,
     airline : airlineOnForm,
     flightNumber : flightnumberonForm,
     departureCity : departurecityonForm,
     departureDate : departuredateonForm,
     departureGate : departuregateonForm,
     arrivalCity : arrivalcityonForm,
     arrivalDate : arrivaldateonForm,
     arrivalGate : arrivalgateonForm,
 
  };
  

  //AJAX call

  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() 
  {
      
      if(xhr.readyState === 4) 
      {


         document.getElementById('new-flight-form').reset();
         location.reload();
      }

  }

  xhr.open('PUT', '/flight/api/flights');

  xhr.send(JSON.stringify(flight));

});



// });



               // <!-- ********************DELETE********************************** -->



document.getElementById('delete-flight').addEventListener('click', function(event) 
{

  event.preventDefault();

  //get data from form
  var idOnForm = document.getElementById('flight-id').value;
  var airlineOnForm = document.getElementById('flight-airline').value;
  var flightnumberonForm = document.getElementById('flight-flightnumber').value;
  var departurecityonForm = document.getElementById('flight-departurecity').value;
  var departuredateonForm = document.getElementById('flight-departuredate').value;
  var departuregateonForm = document.getElementById('flight-departuregate').value;
  var arrivalcityonForm = document.getElementById('flight-arrivalcity').value;
  var arrivaldateonForm = document.getElementById('flight-arrivaldate').value;
  var arrivalgateonForm = document.getElementById('flight-arrivalgate').value;

  var flight = {
      
     id: idOnForm,
     airline : airlineOnForm,
     flightNumber : flightnumberonForm,
     departureCity : departurecityonForm,
     departureDate : departuredateonForm,
     departureGate : departuregateonForm,
     arrivalCity : arrivalcityonForm,
     arrivalDate : arrivaldateonForm,
     arrivalGate : arrivalgateonForm,
 
  };
  

  //AJAX call

  let xhr = new XMLHttpRequest();

  xhr.onreadystatechange = function() 
  {
      
      if(xhr.readyState === 4) 
      {


         document.getElementById('new-flight-form').reset();
         location.reload();
      }

  }

  xhr.open('DELETE', '/flight/api/flights');

  xhr.send(JSON.stringify(flight));

});







//  <!-- *********************enter event******************* -->

document.addEventListener('keypress', function(e){
    if (e.key === "Enter")
    {

 event.preventDefault();
  
  var flightnumberonForm = document.getElementById('flight-flightnumber').value;
  

  let xhr1 = new XMLHttpRequest();

xhr1.onreadystatechange = function() 
{

if(xhr1.readyState === 4) 
{

 console.log(JSON.parse(xhr1.responseText));

 var flightArray = JSON.parse(xhr1.responseText);

 flightArray.forEach(flightElement => {

      if (flightElement.flightNumber == flightnumberonForm)
      {

        document.getElementById('flight-id').value = flightElement.id;
        document.getElementById('flight-airline').value = flightElement.airline;
        document.getElementById('flight-flightnumber').value = flightElement.flightNumber;
        document.getElementById('flight-departurecity').value = flightElement.departureCity;
        document.getElementById('flight-departuredate').value = flightElement.departureDate;
        document.getElementById('flight-departuregate').value = flightElement.departureGate;
        document.getElementById('flight-arrivalcity').value = flightElement.arrivalCity;
        document.getElementById('flight-arrivaldate').value = flightElement.arrivalDate;
        document.getElementById('flight-arrivalgate').value = flightElement.arrivalGate;

      }
 
 });
}

}

xhr1.open('GET', '/flight/api/flights');

xhr1.send();


  }
});
