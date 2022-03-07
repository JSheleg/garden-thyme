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

        const url = `http://localhost:8080/plants`;
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
            .then(result => console.log(result))
            .catch(error => console.log(error));
    }

    return (
        <>
            <h1>Create Plant</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="title">Title</label>
                    <input type="text" id="title" name="title"
                        className="form-control"
                        value={plant.title} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="servings">Servings</label>
                    <input type="text" id="servings" name="servings"
                        className="form-control"
                        value={plant.servings} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="prepTime">Prep Time</label>
                    <input type="text" id="prepTime" name="prepTime"
                        className="form-control"
                        value={plant.prepTime} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="cookTime">Cook Time</label>
                    <input type="text" id="cookTime" name="cookTime"
                        className="form-control"
                        value={plant.cookTime} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="category">Category</label>
                    <select name="category" value={plant.category} onChange={handleChange}>
                        <option value="Carnivore">Carnivore</option>
                        <option value="Herbivore">Herbivore</option>
                        <option value="Omnivore">Omnivore</option>
                    </select>
                </div>
                <div className="mb-3">
                    <label htmlFor="description">Description</label>
                </div>
                <div className="mb-3">
                    <textarea name="description" cols="40" rows="5" value={plant.description} onChange={handleChange}/>
                </div>
                <div className="mb-3">
                    <button className="btn btn-primary mr-3" type="submit">Create</button>
                    <button className="btn btn-secondary" type="button" onClick={() => window.location.href = "/"}>Cancel</button>
                </div>
           </form>
        </>
    );
}

export default PlantForm;