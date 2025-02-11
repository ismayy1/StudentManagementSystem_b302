import React, { useRef } from 'react';
import { ArrowRight, CheckCircle, Link } from 'lucide-react';

import { Car as CarIcon, User, BarChart2, Settings } from 'lucide-react';
import { useLocation, useNavigate } from 'react-router-dom';
import { ThemeToggle } from '../../contexts/ThemeContext';
import '../../index.css';
import { Link as RouterLink } from 'react-router-dom';

export const ServicesHeader: React.FC = () => {
  const highlights = [
    { id: 1, text: "Professional Expertise" },
    { id: 2, text: "24/7 Support" },
    { id: 3, text: "Tailored Solutions" }
  ];

  
  const location = useLocation();
  const navigate = useNavigate();
  const user = localStorage.getItem('user');

  const formRef = useRef<HTMLDivElement>(null);

  const handleButtonClick = () => {
    if (formRef.current) {
      formRef.current.scrollIntoView({ behavior: 'smooth' });
    }
  };

  const handleVehiclesClick = () => {
    window.scrollTo({
      top: window.innerHeight,
      behavior: 'smooth'
    });
  };

  const handleServicesClick = () => {
    navigate('/services');
  };

  return (
    <>
      <nav className="fixed w-full top-0 z-50 px-4 py-4 flex justify-between items-center bg-[rgba(255,255,255,0.568)] dark:bg-black/40 backdrop-blur-sm">
          <RouterLink to="/" className="flex items-center gap-2 text-2xl font-bold">
            <CarIcon size={32} className="text-black dark:text-[#eff1f3d7]" />
            <span className="text-black dark:text-[#eff1f3d7]">Car-Hub</span>
          </RouterLink>
          <div className="flex items-center gap-4">
            {user ? (
              <>
                <RouterLink
                  to="/"
                  className={`flex items-center gap-2 px-4 py-2 rounded-md hover:bg-[#11355baf] dark:hover:bg-[#11355baf] transition-colors text-black dark:text-[#eff1f3d7] ${
                    location.pathname === '/' ? 'bg-[#11355baf]' : ''
                  }`}
                >
                  <CarIcon size={20} />
                  <span>Cars</span>
                </RouterLink>
                <RouterLink
                  to="/services"
                  className={`flex items-center gap-2 px-4 py-2 rounded-md hover:bg-[#11355baf] dark:hover:bg-[#11355baf] transition-colors text-black dark:text-[#eff1f3d7] ${
                    location.pathname === '/services' ? 'bg-[#11355baf]' : ''
                  }`}
                >
                  <Settings size={20} />
                  <span>Services</span>
                </RouterLink>
                <RouterLink
                  to="/statistics"
                  className={`flex items-center gap-2 px-4 py-2 rounded-md hover:bg-[#11355baf] dark:hover:bg-[#11355baf] transition-colors text-black dark:text-[#eff1f3d7] ${
                    location.pathname === '/statistics' ? 'bg-[#11355baf]' : ''
                  }`}
                >
                  <BarChart2 size={20} />
                  <span>Statistics</span>
                </RouterLink>
                <RouterLink
                  to="/admin"
                  className={`flex items-center gap-2 px-4 py-2 rounded-md hover:bg-[#11355baf] dark:hover:bg-[#11355baf] transition-colors text-black dark:text-[#eff1f3d7] ${
                    location.pathname === '/admin' ? 'bg-[#11355baf]' : ''
                  }`}
                >
                  <User size={20} />
                  <span>Admin</span>
                </RouterLink>
              </>
            ) : (
              <RouterLink
                to="/register"
                className="flex items-center gap-2 hover:text-blue-200 transition-colors text-black dark:text-[#eff1f3d7]"
                onClick={handleButtonClick}
              >
                <User size={20} />
                <span>Register/Login</span>
              </RouterLink>
            )}
            
          </div>
          
          <div className="ml-4 border-l border-blue-500 dark:border-blue-700 pl-4">
              <ThemeToggle />
            </div>
        </nav>

      <header className="mt-[70px]">
        <div className="relative bg-gradient-to-r from-blue-600 to-blue-800">
        {/* Background Pattern */}
        <div className="absolute inset-0 opacity-10">
          <div className="absolute inset-0" 
              style={{
                backgroundImage: `radial-gradient(circle at 25px 25px, white 2%, transparent 0%)`,
                backgroundSize: '50px 50px'
              }} />
        </div>

        {/* Content Container */}
        <div className="relative max-w-7xl mx-auto px-4 py-16 sm:px-6 lg:px-8">
          {/* Main Header Content */}
          <div className="text-center">
            <h1 className="text-4xl font-bold tracking-tight text-white sm:text-5xl lg:text-6xl">
              Our Services
            </h1>
            <p className="mt-6 max-w-2xl mx-auto text-xl text-blue-100">
              Delivering exceptional solutions to help your business thrive in the digital age
            </p>
          </div>

          {/* Highlights Section */}
          <div className="mt-12 grid grid-cols-1 gap-6 sm:grid-cols-3 max-w-4xl mx-auto">
            {highlights.map((highlight) => (
              <div
                key={highlight.id}
                className="flex items-center justify-center space-x-2 bg-white/10 backdrop-blur-sm rounded-lg p-4"
              >
                <CheckCircle className="h-5 w-5 text-blue-200" />
                <span className="text-white font-medium">{highlight.text}</span>
              </div>
            ))}
          </div>

          {/* CTA Button */}
          <div className="mt-12 text-center">
            <button className="inline-flex items-center px-6 py-3 border border-transparent text-base font-medium rounded-md text-blue-700 bg-white hover:bg-blue-50 transition-colors duration-200">
              Explore Our Services
              <ArrowRight className="ml-2 h-5 w-5" />
            </button>
          </div>
        </div>
      </div>
      </header>
    </>
  );
};

// export default ServicesHeader;