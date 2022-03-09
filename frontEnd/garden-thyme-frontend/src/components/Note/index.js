

function Note(n) {

    function handleDelete() {
        fetch(`http://localhost:8080/note/${n.id}`, { method: "DELETE" })
            .then(() => { console.log("note has been deleted")
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
                    <h5>Note: {n.text}</h5>
                    <div className="card-footer d-flex justify-content-center">
                        <button className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Note;
