import { useState } from 'react';

function PlantForm() {

    const [plant, setPlant] = useState('');

    function handleChange(evt) {
        const clone = { ...plant };
        clone[evt.target.name] = evt.target.value;
        setPlant(clone);
    }

    function handleSubmit(evt) {
        evt.preventDefault();

        console.log(plant)
        const url = `http://localhost:8082/plant`;
        const method = "POST"
        const expectedStatus = 201;

        const init = {
            method,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json",
                // "Access-Control-Allow-Origin": "http://localhost:8082",
                // "Access-Control-Allow-Methods": "GET, OPTIONS, POST, PUT"

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
                window.location.href = "/"
            })
            .catch(error => {console.log(error); console.log(plant)});
    }

    return (
        <>
            <h1>Create Plant</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="plantName">Name</label>
                    <input type="text" id="plantName" name="plantName"
                        className="form-control"
                        value={plant.plantName} onChange={handleChange} />
                </div>


                <div className="mb-3">
                    <label htmlFor="nickname">Nickname</label>
                    <input type="text" id="nickname" name="nickname"
                        className="form-control"
                        value={plant.nickname} onChange={handleChange} />
                </div>


                <div className="mb-3">
                    <label htmlFor="scientificName">Scientific Name</label>
                    <input type="text" id="scientificName" name="scientificName"
                        className="form-control"
                        value={plant.scientificName} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label htmlFor="sunlightHours">Sunlight </label>
                    <select name="sunlightHours" value={plant.sunlightHours} onChange={handleChange}>
                        <option value="" disabled selected>Select your option</option>
                        <option value="Full Sun">Full Sun</option>
                        <option value="Part Sun">Part Sun</option>
                        <option value="Part Shade">Part Shade</option>
                        <option value="Full Shade">Full Shade</option>
                    </select>
                </div>
                <div className="mb-3">
                    <label htmlFor="waterFrequency">Water Frequency </label>
                    <select name="waterFrequency" value={plant.waterFrequency} onChange={handleChange}>
                    <option value="" disabled selected>Select your option</option>
                        <option value="3 Times Per Week">3 Times Per Week</option>
                        <option value="1 Times Per Week">1 Times Per Week</option>
                        <option value="1 Time Per 2 Weeks">1 Time Per 2 Weeks</option>
                        <option value="1 Timer Per Month">1 Timer Per Month</option>
                    </select>
                </div>
                <div className="mb-3">
                    <label htmlFor="zoneId">Zone </label>
                    <select name="zoneId" value={plant.zoneId} onChange={handleChange}>
                        <option value="" disabled selected>Select your option</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                </div>
                {/* <div className="mb-3">
                    <label htmlFor="description">Description</label>
                </div>
                <div className="mb-3">
                    <textarea name="description" cols="40" rows="5" value={plant.description} onChange={handleChange}/>
                </div> */}
                <div className="mb-3">
                    <button className="btn btn-primary mr-3" type="submit">Create</button>
                    <button className="btn btn-secondary" type="button" onClick={() => window.location.href = "/"}>Cancel</button>
                </div>
           </form>
        </>
    );
}

export default PlantForm;