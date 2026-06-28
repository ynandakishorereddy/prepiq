import { Link, useNavigate } from 'react-router-dom';
import { LogIn } from 'lucide-react';

export default function LoginPage() {
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    navigate('/dashboard/home');
  };

  return (
    <div className="flex flex-col items-center justify-center h-full w-full" style={{ minHeight: '100vh' }}>
      <div className="glass-card" style={{ width: '100%', maxWidth: '400px' }}>
        <div className="text-center mb-lg">
          <h2 className="mb-sm">Welcome Back</h2>
          <p className="text-secondary">Sign in to continue your prep journey</p>
        </div>

        <form onSubmit={handleLogin} className="flex-col gap-md">
          <div className="input-group">
            <label className="input-label">Email</label>
            <input type="email" className="input-field" placeholder="you@example.com" required />
          </div>
          
          <div className="input-group mb-lg">
            <label className="input-label">Password</label>
            <input type="password" className="input-field" placeholder="••••••••" required />
          </div>

          <button type="submit" className="btn btn-primary w-full justify-center">
            <LogIn size={20} />
            Sign In
          </button>
        </form>

        <div className="text-center mt-lg">
          <p className="text-secondary">
            Don't have an account? <Link to="/signup" className="text-gradient" style={{ textDecoration: 'none', fontWeight: 600 }}>Sign up</Link>
          </p>
        </div>
      </div>
    </div>
  );
}
