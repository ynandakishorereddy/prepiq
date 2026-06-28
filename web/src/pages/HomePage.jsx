import { BrainCircuit, Trophy, Target } from 'lucide-react';
import { useNavigate } from 'react-router-dom';

export default function HomePage() {
  const navigate = useNavigate();

  return (
    <div>
      <h2 className="mb-md text-gradient" style={{ fontSize: '2rem' }}>Welcome back!</h2>
      <p className="text-secondary mb-xl">Ready to continue your interview preparation?</p>
      
      <div className="flex gap-md" style={{ flexWrap: 'wrap' }}>
        <div className="glass-card flex-col gap-sm" style={{ flex: '1 1 300px' }}>
          <div className="flex justify-between items-center mb-sm">
            <h3 className="text-primary">Next Session</h3>
            <div className="btn-icon" style={{ background: 'var(--bg-secondary)' }}>
              <BrainCircuit size={20} className="text-accent-primary" style={{ color: 'var(--accent-primary)' }} />
            </div>
          </div>
          <p className="text-secondary">Technical Interview - System Design</p>
          <button 
            className="btn btn-primary mt-md" 
            onClick={() => navigate('/practice/answer')}
          >
            Start Practice
          </button>
        </div>

        <div className="glass-card flex-col gap-sm" style={{ flex: '1 1 300px' }}>
          <div className="flex justify-between items-center mb-sm">
            <h3 className="text-primary">Performance</h3>
            <div className="btn-icon" style={{ background: 'var(--bg-secondary)' }}>
              <Trophy size={20} style={{ color: 'var(--warning)' }} />
            </div>
          </div>
          <div className="flex items-center justify-center h-full">
            <h1 className="text-gradient" style={{ fontSize: '3rem' }}>85%</h1>
          </div>
          <p className="text-center text-secondary">Average Match Score</p>
        </div>

        <div className="glass-card flex-col gap-sm" style={{ flex: '1 1 300px' }}>
          <div className="flex justify-between items-center mb-sm">
            <h3 className="text-primary">Goals</h3>
            <div className="btn-icon" style={{ background: 'var(--bg-secondary)' }}>
              <Target size={20} style={{ color: 'var(--success)' }} />
            </div>
          </div>
          <p className="text-secondary">Complete 5 mock interviews this week.</p>
          <div className="mt-md w-full" style={{ background: 'var(--bg-secondary)', height: '8px', borderRadius: '4px', overflow: 'hidden' }}>
            <div style={{ width: '60%', background: 'var(--success)', height: '100%' }}></div>
          </div>
          <p className="text-secondary text-right" style={{ fontSize: '0.8rem' }}>3/5 Completed</p>
        </div>
      </div>
    </div>
  );
}
