import React, { useRef } from 'react';
import { Car as CarIcon, User, BarChart2, Settings } from 'lucide-react';
import { Link, useLocation } from 'react-router-dom';
import { ThemeToggle } from '../contexts/ThemeContext';
import '../index.css';

export const Header: React.FC = () => {
  const location = useLocation();
  const user = localStorage.getItem('user');

  const formRef = useRef<HTMLDivElement>(null);

  const isActive = (path: string) => {
    return location.pathname === path ? 'bg-blue-700' : '';
  };

  const handleButtonClick = () => {
    if (formRef.current) {
      formRef.current.scrollIntoView({ behavior: 'smooth' });
    }
  };

  return (
    <>
      <header className="bg-gradient-to-r from-blue-600 to-blue-800 dark:from-blue-800 dark:to-blue-900 text-white text-white import-index">
        <div className="max-w-7xl mx-auto">
          {/* Top Navigation */}
          <nav className="px-4 py-4 flex justify-between items-center">
            <Link to="/" className="flex items-center gap-2 text-2xl font-bold">
              <CarIcon size={32} className="text-white" />
              <span>Car-Hub</span>
            </Link>
            <div className="flex items-center gap-4">
              {user ? (
                <>
                  <Link
                    to="/"
                    className={`flex items-center gap-2 px-4 py-2 rounded-md hover:bg-blue-700 dark:hover:bg-blue-600 transition-colors ${isActive(
                      '/'
                    )}`}
                  >
                    <CarIcon size={20} />
                    <span>Cars</span>
                  </Link>
                  <Link
                    to="/services"
                    className={`flex items-center gap-2 px-4 py-2 rounded-md hover:bg-blue-700 dark:hover:bg-blue-600 transition-colors ${isActive(
                      '/services'
                    )}`}
                  >
                    <Settings size={20} />
                    <span>Services</span>
                  </Link>
                  <Link
                    to="/statistics"
                    className={`flex items-center gap-2 px-4 py-2 rounded-md hover:bg-blue-700 dark:hover:bg-blue-600 transition-colors ${isActive(
                      '/statistics'
                    )}`}
                  >
                    <BarChart2 size={20} />
                    <span>Statistics</span>
                  </Link>
                  <Link
                    to="/admin"
                    className={`flex items-center gap-2 px-4 py-2 rounded-md hover:bg-blue-700 dark:hover:bg-blue-600 transition-colors ${isActive(
                      '/admin'
                    )}`}
                  >
                    <User size={20} />
                    <span>Admin</span>
                  </Link>
                </>
              ) : (
                <Link
                  to="/register"
                  className="flex items-center gap-2 hover:text-blue-200 transition-colors"
                  onClick={handleButtonClick}
                >
                  <User size={20} />
                  <span>Register/Login</span>
                </Link>
              )}

            <ThemeToggle />
            
            </div>
          </nav>  

          <div className="relative h-64 overflow-hidden loginForum"></div>

          <div className="button-container">
            <button>Available Vehicles on the Market</button>
            <button>Our Partner Vehicle Services</button>
          </div>

        </div>
      </header>
    </>
  );
};