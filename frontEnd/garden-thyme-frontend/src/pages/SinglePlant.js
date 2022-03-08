import React from 'react';

import { useParams } from "react-router-dom";


const SinglePlant = () => {

    const [plant, setPlant] = useState({});

    const { id } = useParams()
    useEffect(() => {
      fetchFromAPI();
    }, []);

    function fetchFromAPI() {
        fetch("http://localhost:8080/plant/" + id )
            .then(response => response.json())
            .then(result => { console.log(JSON.stringify(result)); setPlant(result); })
            .catch(console.log);
    }

    // need to make for more than 1 plant!
    
    return (    

        
      <div>
        <div className="card mb-3">
              Looking for plant {id}
              


        </div>

        {/* {thought.reactionCount > 0 && <ReactionList reactions= {thought.reactions} />}
        {Auth.loggedIn() && <ReactionForm thoughtId={thought._id} />} */}
      </div>
    );
};

export default SinglePlant