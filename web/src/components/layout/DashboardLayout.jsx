import { Outlet, NavLink } from 'react-router-dom';
import { Home, Dumbbell, Bell, User } from 'lucide-react';

export default function DashboardLayout() {
  const navItems = [
    { name: 'Home', path: '/dashboard/home', icon: Home },
    { name: 'Practice', path: '/dashboard/practice', icon: Dumbbell },
    { name: 'Reminders', path: '/dashboard/reminders', icon: Bell },
    { name: 'Profile', path: '/dashboard/profile', icon: User },
  ];

  return (
    <div className="app-container">
      {/* Desktop Sidebar */}
      <aside className="sidebar">
        <div className="p-lg mb-lg">
          <h1 className="text-gradient">PrepIQ</h1>
        </div>
        
        <nav className="flex-col px-md" style={{ padding: '0 1rem', gap: '0.25rem' }}>
          {navItems.map((item) => (
            <NavLink
              key={item.path}
              to={item.path}
              className={({ isActive }) => `nav-link ${isActive ? 'active' : ''}`}
            >
              <item.icon size={20} />
              <span>{item.name}</span>
            </NavLink>
          ))}
        </nav>
      </aside>

      {/* Main Content Area */}
      <main className="main-content">
        <Outlet />
      </main>
      
      {/* Mobile Bottom Nav */}
      <nav className="mobile-bottom-nav">
        {navItems.map((item) => (
          <NavLink
            key={item.path}
            to={item.path}
            className={({ isActive }) => `flex-col items-center p-sm ${isActive ? 'text-gradient' : 'text-secondary'}`}
            style={{ textDecoration: 'none', gap: '0.25rem', fontSize: '0.75rem' }}
          >
            <item.icon size={24} color={window.location.pathname.includes(item.path) ? 'var(--accent-primary)' : 'currentColor'} />
            <span style={{ fontWeight: window.location.pathname.includes(item.path) ? '600' : '400' }}>{item.name}</span>
          </NavLink>
        ))}
      </nav>
    </div>
  );
}
