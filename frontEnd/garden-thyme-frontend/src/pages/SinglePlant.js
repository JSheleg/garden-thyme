import React from 'react';
import { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import Note from '../components/Note'


const SinglePlant = () => {
    const { id } = useParams()
    const [plant, setPlant] = useState({});
    const [note, setNote] = useState({plantId: id});


    function handleChange(evt) {
      const clone = { ...note };
      clone[evt.target.name] = evt.target.value;
      setNote(clone);
    }

    function handleSubmit(evt) {
      evt.preventDefault();

      console.log(plant)
      const url = `http://localhost:8080/note`;
      const method = "POST"
      const expectedStatus = 201;

      const init = {
          method,
          headers: {
              "Content-Type": "application/json",
              "Accept": "application/json"
          },
          body: JSON.stringify(plant)
      };

      fetch(url, init)
          .then(response => {

              if (response.status === expectedStatus) {
                 return response.json
              }
              return Promise.reject(`Didn't receive expected status: ${expectedStatus}`);
          })
          .then(result => {
              console.log(result)
              window.location.href = "/plant/" + id
          })
          .catch(error => {console.log(error);console.log(note)});
  }

    const decoyPlant = {
      plantName: "Carl",
      nickname: "Carlina",
      scientificName: "Carlursa Carlonia",
      sunlightHours: "Full Sun",
      waterFrequency: "once per week",
      zoneId: "3",
      notes: [
        {id:1,text:"hello this is note 1"},
        {id:2,text:"hello this is note 2"}]
    }

    
    useEffect(() => {
      fetchFromAPI();
    }, []);

    function fetchFromAPI() {
        fetch("http://localhost:8080/plant/" + id )
            .then(response => response.json())
            .then(result => { console.log(JSON.stringify(result)); setPlant(decoyPlant); })
            .catch(error => {console.log(error)
            setPlant(decoyPlant)});
              // {plantName: "Plant not found"}
              
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
              <h5>Notes: </h5>
              <div className="row row-cols-3">
                    {plant.notes ? <div>{
                      plant.notes.map(n => <Note key={n.id} text = {n.text}/>)
                    }</div> :
                    <div>loading</div>
                    }
              </div>
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="note">Add Note:</label>
                </div>
                <div className="mb-3">
                    <textarea name="text" cols="40" rows="5" value={note.text} onChange={handleChange}/>
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