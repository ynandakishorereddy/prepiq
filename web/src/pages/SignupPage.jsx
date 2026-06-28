import { Link, useNavigate } from 'react-router-dom';
import { UserPlus } from 'lucide-react';

export default function SignupPage() {
  const navigate = useNavigate();

  const handleSignup = (e) => {
    e.preventDefault();
    navigate('/dashboard/home');
  };

  return (
    <div className="flex flex-col items-center justify-center h-full w-full" style={{ minHeight: '100vh' }}>
      <div className="glass-card" style={{ width: '100%', maxWidth: '400px' }}>
        <div className="text-center mb-lg">
          <h2 className="mb-sm">Create Account</h2>
          <p className="text-secondary">Join PrepIQ to start practicing</p>
        </div>

        <form onSubmit={handleSignup} className="flex-col gap-md">
          <div className="input-group">
            <label className="input-label">Full Name</label>
            <input type="text" className="input-field" placeholder="John Doe" required />
          </div>
          
          <div className="input-group">
            <label className="input-label">Email</label>
            <input type="email" className="input-field" placeholder="you@example.com" required />
          </div>
          
          <div className="input-group mb-lg">
            <label className="input-label">Password</label>
            <input type="password" className="input-field" placeholder="••••••••" required />
          </div>

          <button type="submit" className="btn btn-primary w-full justify-center">
            <UserPlus size={20} />
            Sign Up
          </button>
        </form>

        <div className="text-center mt-lg">
          <p className="text-secondary">
            Already have an account? <Link to="/login" className="text-gradient" style={{ textDecoration: 'none', fontWeight: 600 }}>Sign in</Link>
          </p>
        </div>
      </div>
    </div>
  );
}
