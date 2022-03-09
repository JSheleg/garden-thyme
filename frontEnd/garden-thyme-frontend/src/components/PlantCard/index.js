

function PlantCard({ p }) {

    function handleDelete() {
        fetch(`http://localhost:8080/plant/${p.id}`, { method: "DELETE" })
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
                    <h5>Name: {p.plantName}</h5>
                    <h5>Nickname: {p.nickname}</h5>
                    <h5>Scientific Name: {p.scientificName}</h5>
                    <h5>Sunlight: {p.sunlightHours}</h5>
                    <h5>Water: {p.waterFrequency}</h5>
                    <h5>Zone: {p.zoneId}</h5>
                    <div className="card-footer d-flex justify-content-center">
                        <button className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                        {/* <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "edit-form", recipe: recipe })}>Edit</button> */}
                        <button className="btn btn-secondary" type="button" onClick={() => window.location.href = "/plant/"+ p.id}>Details</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default PlantCard;
