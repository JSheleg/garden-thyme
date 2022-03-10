

function PlantCard({plant} ) {


    function handleDelete() {
        fetch(`http://localhost:8082/plant/${plant.id}`, { method: "DELETE" })
            .then(() => { console.log("plant has been deleted")
            setTimeout(() => {console.log("this is the third message")
                                window.location.reload();
        }, 1000);
        })
            .catch(error => {console.log(error)});
    }

    return (
        <div className="col">
            <div className="card">
                <div className="card-body">
                    {console.log(plant)}
                    <h5>Name: {plant.plantName}</h5>
                    <h5>Nickname: {plant.nickname}</h5>
                    <h5>Scientific Name: {plant.scientificName}</h5>
                    <h5>Sunlight: {plant.sunlightHours}</h5>
                    <h5>Water: {plant.waterFrequency}</h5>
                    <h5>Zone: {plant.zoneId}</h5>
                    <div className="card-footer d-flex justify-content-center">
                        <button className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                        {/* <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "edit-form", recipe: recipe })}>Edit</button> */}
                        <button className="btn btn-secondary" type="button" onClick={() => window.location.href = "/plant/"+ plant.id}>Details</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default PlantCard;
