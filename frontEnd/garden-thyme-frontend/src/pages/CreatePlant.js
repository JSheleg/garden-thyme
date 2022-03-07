import React from 'react';
import PlantForm from '../components/PlantForm';

const CreatePlant = () => {

    // // use useQuery hook to make query request
    // const { loading, data }= useQuery(QUERY_THOUGHTS)
  
    // const { data: userData } = useQuery(QUERY_ME_BASIC);
  
    // const thoughts = data?.thoughts || [];
    // console.log(thoughts);
  
    // const loggedIn = Auth.loggedIn()
  
  
  
  
    return (
      <main>
          <div className='flex-row justify-space-between'>
            <PlantForm/>
          </div>

      </main>
    );
  };
  
  export default CreatePlant;
  