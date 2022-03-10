import React from 'react';
import { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import Note from '../components/Note'


const SinglePlant = () => {
    const { id } = useParams()
    const [plant, setPlant] = useState({});
    const [note, setNote] = useState({plantId: id});
    const [zone, setZone] = useState([])

    function getZones() {
      fetch("http://localhost:8082/zone/")
      .then(response => response.json())
      .then(result => { JSON.stringify(result); console.log(result); setZone(result); })
      .catch(error => {console.log(error)})
    }

    function handleChange(evt) {
      const clone = { ...note };
      clone[evt.target.name] = evt.target.value;
      setNote(clone);
    }

    function handleSubmit(evt) {
      evt.preventDefault();

      console.log(note)
      const url = `http://localhost:8082/note`;
      const method = "POST"
      const expectedStatus = 201;

      const init = {
          method,
          headers: {
              "Content-Type": "application/json",
              "Accept": "application/json"
          },
          body: JSON.stringify(note)
      };

      fetch(url, init)
          .then(response => {
              console.log(init)
              if (response.status === expectedStatus) {
                 return response.json
              }
              return Promise.reject(`Didn't receive expected status: ${expectedStatus}`);
          })
          .then(result => {
              console.log(result)
              setTimeout(()=>{window.location.href = "/plant/" + id},1000)

          })
          .catch(error => {console.log(error);console.log(note)});
  }


    
    useEffect(() => {
      fetchFromAPI();
      getZones();
    }, []);

    function fetchFromAPI() {
        fetch("http://localhost:8082/plant/" + id )
            .then(response => response.json())
            .then(result => { JSON.stringify(result); console.log(result); setPlant(result); })
            .catch(error => {console.log(error);setPlant({plantName: "Plant not found"})})
            // setPlant(decoyPlant)});
             
              
    }

    // need to make for more than 1 plant!
    
    return (    

        
      <div>
        <div className="card mb-3">
              Looking for plant {id}
              <h5>Name: {plant.plantName}</h5>
              <h5>Nickname: {plant.nickname}</h5>
              <h5>Scientific Name: {plant.scientificName}</h5>
              <h5>Sunlight: {plant.sunlightHours}</h5>
              <h5>Water: {plant.waterFrequency}</h5>
              <h5>Zone: {plant.zoneId}</h5>
              <div className="row row-cols-3">
                    {zone ? <div>{
                      zone.map(z => <div>Zone Id: {z.zoneId}, {z.lowTemp}°F - {z.highTemp}°F</div>)
                    }</div> :
                    <div>loading</div>
                    }
              </div>
              <h5>Notes: </h5>
              <div className="row row-cols-3">
                    {plant.notes ? <div>{
                      plant.notes.map(n => <Note key={n.id} note = {n}/>)
                    }</div> :
                    <div>loading</div>
                    }
              </div>
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="note">Add Note:</label>
                </div>
                <div className="mb-3">
                    <textarea name="content" cols="40" rows="5" value={note.content} onChange={handleChange}/>
                </div>
                <div className="mb-3">
                    <button className="btn btn-primary mr-3" type="submit">Save Note</button>
                </div>
           </form>


              
        </div>
      </div>
    );
};

export default SinglePlant