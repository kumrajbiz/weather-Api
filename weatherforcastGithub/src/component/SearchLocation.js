import React, { useState } from 'react'
import { useNavigation } from 'react-router-dom';
import LocationService from '../sevices/LocationService';

const SearchLocation = () => {
/* we need to Handle the data(i.e location), so we have to use reacthooks using functional component
along wiht usestate managment after submit will pass the data to backend*/

  const [location, setLocation] = useState({ location: "" });
  const navigate = useNavigation();

  const handleChange = (l) => {
    const value = l.target.value;
    setLocation(l.target.location);
    setLocation({ ...location,[l.target.location]: value});
  };

  const reset = (l) => {
    l.preventDefault();
    setLocation({ location: "" })
  }

  const sendLocation = (l) => {
    l.preventDefault();
    LocationService.SearchLocation(location).then((response) => {
      console.log(response);
    })
    .catch((error) => {
      console.log(error);
    });
  };

  return (
    <div className="flex max-w-2xl mx-auto shadow border-b">
      <div className="px-8 py-8">
          <div className="font-thick text-2xl traking-wider">
            <h1> Enter location for search </h1>
          </div>
          <div className="intem-center justify-center h-14 w-full my-4"> 
            <input type="text" name="location" value={location.location} 
            onChange={(l)=> handleChange(l)}
            className="h-10 w-96 border mt-2 px-2 py-2"></input>
          </div>
          <div className="item center justyfy-center h-14 w-full my-4 space-x-8 pt-4">
              <button onClick={sendLocation} className="rounded text-white font-thick bg-blue-600 hover:bg-blue-800 py-2 px-2"> Search </button>
              <button onClick={reset} className="rounded text-white font-thick bg-green-600 hover:bg-green-800 py-2 px-2"> Clear </button>
          </div>
      </div>

    </div>
  );
};

export default SearchLocation