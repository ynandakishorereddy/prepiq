import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { BrainCircuit } from 'lucide-react';

export default function SplashPage() {
  const navigate = useNavigate();

  useEffect(() => {
    // Simulate loading/auth check
    const timer = setTimeout(() => {
      navigate('/login');
    }, 2000);
    return () => clearTimeout(timer);
  }, [navigate]);

  return (
    <div className="flex flex-col items-center justify-center h-full w-full" style={{ minHeight: '100vh' }}>
      <div className="glass-card flex flex-col items-center gap-md" style={{ padding: '4rem', animation: 'pulse 2s infinite' }}>
        <BrainCircuit size={64} className="text-gradient" />
        <h1 className="text-gradient" style={{ fontSize: '3rem', margin: 0 }}>PrepIQ</h1>
        <p className="text-secondary">Elevate your interview game</p>
      </div>
    </div>
  );
}
