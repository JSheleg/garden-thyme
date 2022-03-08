import 'bootstrap/dist/css/bootstrap.css';
import { BrowserRouter as Router, Route, Routes, Redirect } from 'react-router-dom'
import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import NoMatch from './pages/NoMatch'
import SinglePlant from './pages/SinglePlant';
import CreatePlant from './pages/CreatePlant'
import Home from './pages/Home'

function App() {
  return (
    <main className="container">
      <Router>
        <div className='flex-column justify-flex-start min-100-vh'>
        <Header />
          <div className='container'>
            <Routes>
              <Route path='/' element={<Home/>} />
              <Route path="/createPlant" element={<CreatePlant/>} />
              <Route path="/plant/:id" element={<SinglePlant/>} />
            </Routes>

          </div>
        <Footer />
      </div>
      </Router>
    </main>
  );
}

export default App;
