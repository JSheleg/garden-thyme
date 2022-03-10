import React from 'react';
import { useParams } from "react-router-dom";
import { useState, useEffect } from 'react';
import PlantCard from '../components/PlantCard'


const Home = () => {

    // // use useQuery hook to make query request
    // const { loading, data }= useQuery(QUERY_THOUGHTS)
  
    // const { data: userData } = useQuery(QUERY_ME_BASIC);
  
    // const thoughts = data?.thoughts || [];
    // console.log(thoughts);
  
    // const loggedIn = Auth.loggedIn()
  
  

    const [plants, setPlant] = useState([]);

    const { id } = useParams()
    useEffect(() => {
      fetchFromAPI();
    }, []);

    function fetchFromAPI() {
        fetch("http://localhost:8082/plant/")
            .then(response => response.json())
            .then(result => { JSON.stringify(result); console.log(result); setPlant(result); })
            .catch(console.log);
    }

  
    return (
      <main>
          <div className='flex-row justify-space-between'>
            This is the home page

            {plants.length === 0 ? <div className="alert alert-warning">No Plants</div>
                : (<div className="row row-cols-3">
                    {plants.map(p => <PlantCard key={p.id} plant={p} />)}
                  </div>)
            }

          </div>

      </main>
    );
  };
  
  export default Home;
  