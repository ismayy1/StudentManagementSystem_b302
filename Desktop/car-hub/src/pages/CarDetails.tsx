import React from 'react';
import { useParams, Link } from 'react-router-dom';
import { ChevronLeft, Check, Car as CarIcon, Fuel, Gauge, Settings } from 'lucide-react';
import { useCarStore } from '../data/cars';

export const CarDetails: React.FC = () => {
  const { id } = useParams();
  const { cars } = useCarStore();
  const car = cars.find((c) => c.id === id);

  if (!car) {
    return (
      <div className="min-h-screen bg-gray-100 p-8">
        <div className="max-w-7xl mx-auto text-center">
          <h1 className="text-2xl font-bold text-gray-900">Car not found</h1>
          <Link to="/" className="text-blue-600 hover:text-blue-800">
            Return to home
          </Link>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gray-100">
      <div className="max-w-7xl mx-auto px-4 py-8">
        <Link
          to="/"
          className="inline-flex items-center text-blue-600 hover:text-blue-800 mb-6"
        >
          <ChevronLeft size={20} />
          <span>Back to listings</span>
        </Link>

        <div className="bg-white rounded-lg shadow-md overflow-hidden">
          <div className="relative h-96">
            <img
              src={car.imageUrl}
              alt={`${car.make} ${car.model}`}
              className="w-full h-full object-cover"
            />
            <div className="absolute top-4 right-4">
              <span className="px-4 py-2 bg-blue-600 text-white rounded-full font-semibold">
                ${car.price.toLocaleString()}
              </span>
            </div>
          </div>

          <div className="p-6">
            <div className="flex justify-between items-start mb-6">
              <div>
                <h1 className="text-3xl font-bold text-gray-900">
                  {car.make} {car.model}
                </h1>
                <p className="text-lg text-gray-600">{car.year}</p>
              </div>
              <span className="px-3 py-1 bg-blue-100 text-blue-800 rounded-full">
                {car.condition}
              </span>
            </div>

            <div className="grid grid-cols-2 md:grid-cols-4 gap-6 mb-8">
              <div className="flex items-center gap-2">
                <CarIcon className="text-gray-400" />
                <div>
                  <p className="text-sm text-gray-500">Make</p>
                  <p className="font-semibold">{car.make}</p>
                </div>
              </div>
              <div className="flex items-center gap-2">
                <Gauge className="text-gray-400" />
                <div>
                  <p className="text-sm text-gray-500">Mileage</p>
                  <p className="font-semibold">{car.mileage.toLocaleString()} mi</p>
                </div>
              </div>
              <div className="flex items-center gap-2">
                <Fuel className="text-gray-400" />
                <div>
                  <p className="text-sm text-gray-500">Fuel Type</p>
                  <p className="font-semibold">{car.fuelType}</p>
                </div>
              </div>
              <div className="flex items-center gap-2">
                <Settings className="text-gray-400" />
                <div>
                  <p className="text-sm text-gray-500">Transmission</p>
                  <p className="font-semibold">{car.transmission}</p>
                </div>
              </div>
            </div>

            <div className="mb-8">
              <h2 className="text-xl font-semibold mb-4">Features</h2>
              <div className="grid grid-cols-2 md:grid-cols-3 gap-4">
                {car.features?.map((feature, index) => (
                  <div key={index} className="flex items-center gap-2">
                    <Check size={16} className="text-green-500" />
                    <span>{feature}</span>
                  </div>
                ))}
              </div>
            </div>

            <div className="flex justify-center">
              <button className="bg-blue-600 text-white px-8 py-3 rounded-md hover:bg-blue-700 transition-colors">
                Contact Dealer
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};