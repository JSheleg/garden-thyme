import React from 'react';
import { useParams } from "react-router-dom";


const SinglePlant = () => {

    const { id } = useParams()

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