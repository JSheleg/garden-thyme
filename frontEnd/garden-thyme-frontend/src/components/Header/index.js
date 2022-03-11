import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {


  return (

    <header>
      <nav>
        <h1>
          <a href="/" style={{ textDecoration: 'none' }}>Garden Thyme</a>
        </h1>
        <button className="createPlant" >
          <a href="/createPlant" style={{ textDecoration: 'none' }}>Create Plant</a>
        </button>
      </nav>
      </header>

  );
};

export default Header;
